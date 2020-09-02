
.data 

Text1:
   	.ascii "Starbucks: 25 grams\n\0" 

Text2:
   	.ascii "Brownie bites: 20 grams\n\0" 

Text3:
   	.ascii "Per Cookie: 15 grams\n\0" 

Text4:
   	.ascii "How much starbucks did i drink?\n\0"

Text5:
   	.ascii "How many brownie bites did i eat?\n\0" 

Text6:
   	.ascii "How any cookies did i eat?\n\0" 

ThatLine:
   	.ascii "That's \0" 

TotalGrams:
   	.ascii " grams of sugar I ate\n\0" 

Elley:
	.ascii "How much sugar can Elley have?\n\0" 

Elley1:
	.ascii "Elley can only eat \0"

Elley2:

	.ascii " time\n\0"

.text 
.global _start 

_start:
 	mov $Text1, %rdx
 	call PrintCString
 
 	mov $Text2, %rdx
 	call PrintCString
 	
	mov $Text3, %rdx
 	call PrintCString
 	
	mov $Text4, %rdx
 	call PrintCString
 	call ScanInt
 	mov $25, %rax
	imul %rax, %rdx
	mov %rdx, %r8

	mov $Text5, %rdx
	call PrintCString
	call ScanInt
	mov $20, %rax
	imul %rax, %rdx
	add %rdx, %r8

	mov $Text6, %rdx
	call PrintCString
	call ScanInt
	mov $15, %rax
	imul %rax, %rdx
	add %rdx, %r8
	
	mov $ThatLine, %rdx
	call PrintCString	
	mov %r8, %rdx
	call PrintInt	

	mov $TotalGrams, %rdx
	call PrintCString
	
	mov $Elley, %rdx
	call PrintCString
	call ScanInt
	mov %rdx, %rax

	mov $Elley1, %rdx
	call PrintCString
	CQO
	IDIV %r8
        mov %rax, %rdx
	call PrintInt
	mov $Elley2, %rdx
        call PrintCString


	call EndProgram
	
