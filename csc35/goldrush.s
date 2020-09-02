
.data
/* Misc. strings */
intro:  
	.ascii "Gold rush!\nRules:\n- 20 weeks\n- Each week you can buy a sluice or continue working\n- Panning for gold yields $0 - $25\n- Each sluice yields $0 - $75\n\n\0" # This is quite far over the PEP8 79 column maximum line length. 
choice: 
	.ascii "Would you like to (1) go into town to buy a sluice for $100, or (2) continue working?\n\0"
newl:   
	.ascii "\n\0"
wk:     
	.ascii "Week \0"
slcs:   
	.ascii "Sluices: \0"
baln:   
	.ascii "Balance: \0"

/* Sluice strings  */
buy:    
	.ascii "You bought a sluice for $100.\n\0"
debt:   
	.ascii "You don't have enough money to buy a sluce. You decide to continue working instead.\n\0"
brk:    
	.ascii "A sluice broke :(\n\0"

/* Profit strings  */
profg:  
	.ascii "Profit from panning for gold: \0"
profs:  
	.ascii "Profit from sluice: \0"
proff:  
	.ascii "Weekly food cost: \0"

/* Weekend strings */
tot:    
	.ascii "Total for the week:\n\0"
prof:   
	.ascii "Profit from goldpanning: \0"

/* Final calculation strings */
finish: 
	.ascii "\n\n\n==== GAME OVER ====\n\0"
balfin: 
	.ascii "Final balance: \0"

.text
.global _start
	
newline:
    push %rcx
    mov  $newl, %rcx
    call PrintCString
    pop  %rcx
    ret

setred:
    /* Sets the foreground colour to red. */
    push %rcx
    mov  $1, %rcx
    call SetForeColor
    pop  %rcx
    ret

setwhite:
    /* Sets the foreground colour to white. */
    push %rcx
    mov  $7, %rcx
    call SetForeColor
    pop  %rcx
    ret    

_start:
    /* 
     * Display the rules, loop over the main week function 
     * 20 times, then tally result.
     */
    /* Since some PC's may use other default terminal foreground/background colours, let's change to white on black. */
    mov  $0, %rcx
    call SetBackColor
    mov  $7, %rcx
    call SetForeColor
    # This looks SO weird on my MacBook...
    mov  $intro, %rcx
    call PrintCString
    /* Give the user $100 starting money. */
    mov  $100, %rax 
    /* Loop over the week function 20 times. */
    mov  $20, %ecx
main:
    push %rcx
    /* Display how many weeks it's been. */
    call newline
    call newline
    mov  $wk, %rcx
    call PrintCString
    pop  %rcx
    push %rcx
    neg  %rcx        
    add  $21, %rcx 
    call PrintInt
    call newline
    
    /* Display the user's current amount of sluices and money. */
    mov  $slcs, %rcx
    call PrintCString
    mov  %rbx, %rcx
    call PrintInt
    call newline
    mov  $baln, %rcx
    call PrintCString
    mov  %rax, %rcx
    call PrintInt
    call newline

    /* Start the week, then loop to the top  */
    pop  %rcx
    call week
    loop main
    call total
    call EndProgram

week:
    /*
     * Main control for each week. The player decides whether
     * or not to buy a sluice. Then, each sluice's output,
     * the player's gold panning output, the sluices that may break,
     * and the food cost is decided. Profit is output to the screen and
     * added to the player's total.
     */    
    push %rcx		# We have to push the loop control counter while using rcx with the library.
    mov  $choice, %rcx 
    call PrintCString
    call ScanInt
    call ClearScreen
    cmp  $1, %rcx
    jne  continue
    /* Check if the user has enough money, then buy them a sluice. */
    cmp  $100, %rax
    jge  enoughmoney
    mov  $debt, %rcx
    call PrintCString
    jmp  continue
enoughmoney:

    sub  $100, %rax
    inc  %rbx
    mov  $buy, %rcx
    call PrintCString
    # Intentional fall-through to continue.

continue:
    /*
     * Control jumps  here if the user chose not to buy a sluice, or if the user doesn't have enough money.
     * Calculate the amount of money the user earned and determine if any of their sluices broke.
     */
    /* Display gold-panning profit. */
    mov  $profg, %rcx
    call PrintCString
    mov  $25, %rcx
    call Random
    add  %rcx, %rax
    call PrintInt
    call newline
    mov  %rbx, %rcx
sluiceprofit:
    /* Display profit from each sluice. */
    push %rcx
    mov  $profs, %rcx
    call PrintCString
    mov  $76, %rcx
    call Random
    add  %rcx, %rax
    call PrintInt
    call newline
    pop  %rcx
    loop sluiceprofit
    mov  %rbx, %rcx
sluicebroke:
    /* Determine if any sluices have broken. Each have a 10% chance. */
    push %rcx
    mov  $10, %rcx
    call Random
    cmp  $0, %rcx
    jne  nobreak
    /* A sluice broke :( drecrement the sluice counter and tell the user the bad news. */
    dec  %rbx
    call setred
    mov  $brk, %rcx
    call PrintCString
    call setwhite
nobreak:
    pop  %rcx
    loop sluicebroke
    
    /* Finally, determine how much money we spent on food this week. */
    mov  $proff, %rcx
    call PrintCString
    mov  $11, %rcx
    call Random
    add  $10, %rcx
    sub  %rcx, %rax
    call PrintInt
    call newline
     
    /* Return the loop control counter to the proper place and return. The week is done. */
    pop  %rcx
    ret

total:
    /* Print the final balance and terminate. */
    mov  $finish, %rcx
    call PrintCString
    mov  $balfin, %rcx
    call PrintCString
    mov  %rax, %rcx
    call PrintInt
    call newline
    call EndProgram
