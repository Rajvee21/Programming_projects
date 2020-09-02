
.data

Title:
	.ascii "Welcome to the Word Bender Program\n\0"

Word:
	.ascii "Enter a Word to Bend! \n\0"

Sentence:
        .space 100

Space:
	.ascii " \0"

Next:
	.ascii "\n\0"

.text
.global _start


_start:

	mov $Title, %rdx
	call PrintCString

	mov $Word, %rdx
	call PrintCString
	
	mov $Sentence, %rdx
	mov $100, %rcx
	
	call ScanCString
	call LengthCString
	mov %rdx, %r10

	mov %r10, %rax
	mov $2, %rbx
	CQO
	idiv %rbx
	mov %rax, %r11
	mov $0, %rdi
	
		
VLoop:
	cmp %r11, %rdi
	jge VDone
	mov Sentence (%rdi), %dl
	call PrintChar
	mov $Next, %rdx
	call PrintCString
	add $1, %rdi
	jmp VLoop

VDone:
	mov %r11, %rdi
	
HLoop:
        cmp %r10, %rdi
        jge HDone
        mov Sentence (%rdi), %dl
        call PrintChar
        mov $Space, %rdx
        call PrintCString
        add $1, %rdi
        jmp HLoop

HDone:
        mov %r10, %rdi
	mov $Next, %rdx
	call PrintCString
       	
	Call EndProgram
