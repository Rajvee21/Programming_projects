

.data
#introduction of the game
intro:
	.ascii "                                   ====================\n"
 	.ascii "                              WELCOME TO CALIFORNIA GOLD RUSH\n"
 	.ascii "                                   ====================\n"
 	.ascii "\n\n\n"
 	.ascii "Rules:\n"
 	.ascii "1. 20 weeks (5 months)\n" 
 	.ascii "2. Your endurance drops 10-25% each week. If it reaches 0%, the game ends.\n" 	
 	.ascii "3. Panning for gold yields 0-100 dollars.\n" 
 	.ascii "4. A sluice yields 0-1000 dollars (durability drops 20-50% each week)\n" 
 	.ascii "5. Food costs 30-50 dollars.\n\n\n\0"

Week:
	.ascii "Week: \0"

Balance:
	.ascii "You have current balance: $\0"
Cost:
	.ascii "Cost of going to the town $\0"
Endu:
	.ascii "Your current endurance is at \0"
Endu1:
	.ascii "Your endurance increased by: \0"

Sluice:
	.ascii "Sluice integrity is at \0"
SluYield:
	.ascii "The sluice yielded $\0"
SluBroken:
	.ascii "Oppsie! The sluice is broken.(No Yeild)\n\0"
SluRepaired:
	.ascii "Woohhooo!!! You repaired the sluice to 100%.\n\0"
Sunday:
	.ascii "Hey buddy Sunday's here what's your plan: \n1. Doing nothing, \n2. Repairing the sluice (-$100), \n3. Going to downtown.\n\0"

Panning:
	.ascii "Panning for the gold yielded: $\0"

Food:
	.ascii "Your Yummy Tummy Food costed you: $\0"
Ended:
	.ascii "                ====== \n              GAME OVER\n                ====== \n\n       Stop Playing and Go Shopping :) !!! \nYou ended the game with $\0"
Ended1:	
 	.ascii "Your endurance was:\0" 
Error:
	.ascii "Opps!! You did an incorrect input please select either of the option numbers.\n\0"
percent:
	.ascii "%\n\0"
line:
	.ascii "\n\0"

.text

.global _start

_start:

#printing introduction with 100 starting amount
	mov $intro, %rdx
	call PrintCString
	mov $1, %r8
	mov $100, %r9
	mov $100, %r10
	mov $100, %r11

#sunday working
sun:
	cmp $20, %r8
	jge Done
	cmp $0, %r10
	jle Done
	mov $Week, %rdx
	call PrintCString
	mov %r8, %rdx
	call PrintInt
	mov $line, %rdx
	call PrintCString
	mov $Balance, %rdx
	call PrintCString
	mov %r9, %rdx
	call PrintInt
	mov $line, %rdx
	call PrintCString
	mov $Endu, %rdx
	call PrintCString
	mov %r10, %rdx
	call PrintInt
	mov $percent, %rdx
	call PrintCString
	mov $Sluice, %rdx
	call PrintCString
	mov %r11, %rdx
	call PrintInt	
	mov $percent, %rdx
	call PrintCString
	mov $Sunday, %rdx
	call PrintCString
	call ScanInt
	cmp $1, %rdx
	je nothing
	cmp $2, %rdx
	je repair
	cmp $3, %rdx
	je downtown
	jmp error

#error working
error:	
	mov $Error, %rdx
	call PrintCString
	call ScanInt
	cmp $1, %rdx
	je nothing
	cmp $2, %rdx
	je repair
	cmp $3, %rdx
	je downtown
	jmp error
nothing:
	jmp day

#repair working
repair:
	mov $SluRepaired, %rdx
	call PrintCString
	sub $100, %r9
	mov $100, %r11
	jmp day

#downtown working
downtown:	
	mov $Cost, %rdx
	call PrintCString
	mov $150, %rdx
	call Random
	add $50, %rdx
	call PrintInt
	sub %rdx, %r9
	mov $line, %rdx
	call PrintCString
	mov $Endu1, %rdx
	call PrintCString
	mov $20, %rdx
	call Random
	add $5, %rdx
	call PrintInt
	add %rdx, %r10
	mov $line, %rdx
	call PrintCString
	jmp day

#regular day working
day:
	
#panning working
Pann:
	mov $Panning, %rdx
	call PrintCString
	mov $100, %rdx
	call Random
	call PrintInt
	add %rdx, %r9
	mov $line, %rdx
	call PrintCString

	cmp $0, %r11
	jle SluB

#sluice yield working
SluY:
	mov $SluYield, %rdx
	call PrintCString
	mov $1000, %rdx
	call Random
	call PrintInt
	add %rdx, %r9
	mov $line, %rdx
	call PrintCString
	jmp tear

#broken sluice working
SluB:
	mov $SluBroken, %rdx
	call PrintCString

tear:
	mov $15, %rdx
	call Random
	add $10, %rdx
	sub %rdx, %r10

	mov $30, %rdx
	call Random
	add $20, %rdx
	sub %rdx, %r11

	mov $Food, %rdx
	call PrintCString
	mov $20, %rdx
	call Random
	add $30, %rdx
	call PrintInt
	sub %rdx, %r9
	mov $line, %rdx
	call PrintCString
	add $1, %r8
	jmp sun

#game ending working
Done:
	mov $Ended, %rdx
	call PrintCString
	mov %r9, %rdx
	call PrintInt
	mov $line, %rdx
	call PrintCString
	mov $Ended1, %rdx
	call PrintCString
	mov %r10, %rdx
	call PrintInt
	mov $line, %rdx
	call PrintCString

	call EndProgram

