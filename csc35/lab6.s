.data

Disney:
	.ascii "Welcome to Disney! You will be sorted into one of the four characters of DisneyLand.\n\0"

Sorting:	
	.ascii "Please answer the given question to know your personality type.\n\0"

Ques1:
	.ascii "Are you an (1)Introvert or (2)Extrovert\n\0"

Ques2:
	.ascii "Are you a (1)Feeling or (2)Thinking kind of person\n\0"

Ques3:
	.ascii "Are you an (1)Judging or (2)Perciving kind of person\n\0"

Cinderella:
	.ascii "You are Cinderella!\n\0"

Elsa:
	.ascii "Oh! You are an Elsa\n\0"

Flynn:
	.ascii "You are a Flynn Rider\n\0"

Aladin:
	.ascii "You are a Aladin\n\0"
Err:
	.ascii "Opps! Choose 1 or 2\n\0"

.text
.global _start

_start:

	mov $Disney, %rdx
	call PrintCString

	mov $Sorting, %rdx
	call PrintCString

AskQuestion1:

	mov $Ques1, %rdx
	call PrintCString
	call ScanInt
	cmp $1, %rdx
	je AskQuestion2
	cmp $2, %rdx
	je AskQuestion3
	jne Error

AskQuestion2:

	mov $Ques2, %rdx
        call PrintCString
        call ScanInt
        cmp $1, %rdx
        je PrintCinderella
	cmp $2, %rdx
	je PrintElsa
	jne Error

AskQuestion3:

	mov $Ques3, %rdx
        call PrintCString
        call ScanInt
        cmp $1, %rdx
        je PrintFlynn
	cmp $2, %rdx
	je PrintAladin
	jne Error

PrintCinderella:

	mov $Cinderella, %rdx
	call PrintCString
	jmp End

PrintElsa:

        mov $Elsa, %rdx
        call PrintCString
        jmp End

PrintAladin:

        mov $Aladin, %rdx
        call PrintCString
        jmp End

PrintFlynn:

        mov $Flynn, %rdx
        call PrintCString
        jmp End

Error:

	mov $Err, %rdx
	call PrintCString

End:

	call EndProgram
