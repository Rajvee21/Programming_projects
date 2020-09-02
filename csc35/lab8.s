.data 

Prompt:
	.ascii "What is your name?\n\0"
Hey:
	.ascii "Hey, \0"
Quote:
	.ascii "! Don't procrastinate. And learn Math!\n\0"
Name:
	.space 30

.text
.global _start

_start:
	
	mov $1, %rax
	mov $1, %rdi
	mov $Prompt, %rsi
	mov $19, %rdx
	Syscall

	mov $0, %rax
	mov $0, %rdi
	mov $Name, %rsi
	mov $30, %rdx
	Syscall
	
	mov $1, %rax
        mov $1, %rdi
        mov $Hey, %rsi
	mov $5, %rdx
        Syscall

	mov $1, %rax
        mov $1, %rdi
        mov $Name, %rsi				
        mov $5, %rdx             #i took a random name and put the length here  
        Syscall

	mov $1, %rax
        mov $1, %rdi
        mov $Quote, %rsi
        mov $40, %rdx
        Syscall

	mov $60, %rax
	mov $0, %rdi
	Syscall

	
