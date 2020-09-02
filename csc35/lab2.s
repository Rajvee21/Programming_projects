#Printing Monthly Bills


.data

Rent:

	.ascii "Monthly rent payment?\n\0"

Gym:

	.ascii "Monthy gym membership?\n\0"

Disneystuff:

	.ascii "Monthy Disney stuff bills?\n\0"

Make:

	.ascii "How much do you make each month?\n\0"
Used:

	.ascii "Total money used is $\0"
Left:

	.ascii "\nSavings for this month is $\0"


.text
.global _start

_start:

	mov $Rent, %rdx
	call PrintCString
	call ScanInt
	mov %rdx, %r8

	mov $Gym, %rdx
	call PrintCString
	call ScanInt
	mov %rdx, %r9

	mov $Disneystuff, %rdx
	call PrintCString
	call ScanInt
	mov %rdx, %r10

	mov $Make, %rdx
	call PrintCString
	call ScanInt
	mov %rdx, %r11

	mov $Used, %rdx
	call PrintCString

	add %r8, %r9
	add %r9, %r10
	mov %r10, %rdx
	call PrintInt
	
	mov $Left, %rdx
	call PrintCString

	sub %r10, %r11
	mov %r11, %rdx
	call PrintInt

	call EndProgram
