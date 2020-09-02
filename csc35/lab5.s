.data 

Message:
	.ascii "Hogwarts Vending Machine \n\0" 
Wand:
	.ascii "1. Wand (75 cents) \n\0" 
Robes:
	.ascii "2. Plain Work Robes (50 cents) \n\0" 
Hat:
	.ascii "3. Pointed Hat (30 cents) \n\0" 
Gloves:
	.ascii "4. Protected Gloves (25 cents) \n\0" 
Left:
	.ascii "Dispensing \0"
Quarter:
        .ascii " quarter(s) and \0"
Penny:
	 .ascii "penny(s)"

Items:
	.quad Wand
	.quad Robes
	.quad Hat
	.quad Gloves
	.quad Quarter
	.quad Penny

Price:
	.quad 75
	.quad 50
	.quad 30
	.quad 25 
	.quad 25


Money:
	.ascii "Enter Money: \0"

ItemNumber:
	.ascii "Your Selection: \0" 

Change:
	.ascii "Your Change is \0 " 

Space:
	.ascii "\n\0" 

.text 

.global _start 

_start:
	mov $Message, %rdx
	call PrintCString
	
	mov $Space, %rdx
	call PrintCString
	
	mov $Wand, %rdx
	call PrintCString
	
	mov $Robes, %rdx
	call PrintCString
	
	mov $Hat, %rdx
	call PrintCString
	
	mov $Gloves, %rdx
	call PrintCString
	
	mov $Space, %rdx
	call PrintCString
	
	mov $Money, %rdx
	call PrintCString
	call ScanInt
	mov %rdx, %r9
	
	mov $ItemNumber, %rdx
	call PrintCString
	call ScanInt
	mov %rdx, %rdi
	sub $1 ,%rdi
	
	mov Items(,%rdi,8), %rdx
	call PrintCString
	
	mov $Space, %rdx
	call PrintCString
	
	mov $Change, %rdx
	call PrintCString
	mov Price(, %rdi,8), %rdx
	sub %rdx, %r9
	mov %r9, %rdx
	call PrintInt
	
	mov $Space, %rdx
        call PrintCString
	
	mov $Left, %rdx
	call PrintCString
	mov %r9, %rax
        mov $25, %rbx
	CQO
	IDIV %rbx
        mov %rax, %rdx
	call PrintInt
	mov $Quarter, %rdx
        call PrintCString
	mov %r9, %rax
        mov $25, %rbx
        CQO
        IDIV %rbx
        call PrintInt
	mov $Penny, %rdx
	call PrintCString

	mov $Space, %rdx
        call PrintCString

	call EndProgram
