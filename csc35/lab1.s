#Print Hello World 

.data 
Hey:

	.ascii "Hello, World!\n\0"

MyName:

	.ascii "My Name is Rajvee Modi\n\0"

Qouteoftheday:

	.ascii "The more you weight the harder you are to kidnap\n\0."

Linetwo:

	.ascii "Stay Safe, Eat Cake!\n\0"

Graduate:

	.ascii "I will Graduate in \0"

Gradtwo:

	.ascii "from Sacramento State!\n\0"

.text
.global _start


_start:

	mov $Hey, %rdx
	call PrintCString

	mov $MyName, %rdx
	call PrintCString

	mov $Qouteoftheday, %rdx
	call PrintCString

	mov $Linetwo, %rdx
	call PrintCString

	mov $Graduate, %rdx
	call PrintCString

	mov  $2021, %rdx
	call PrintInt

	mov $Gradtwo, %rdx
	call PrintCString

	call EndProgram

