.data

Silly:
	.ascii "Welcome to Silly Sentences!\n\0"

Noun:
	.ascii "1. Player A, enter a noun: \0"

Verb:
	.ascii "2. Player B, enter a verb: \0"

Prep:
	.ascii "3. Player A, enter a preposition: \0"

Noun2:
	.ascii "4. Player B, enter a second noun: \0"

Final:
	.ascii "Your Sentence is : \n\0"

Space:
	.ascii " \0"

NewLine:
	.ascii "\n\0"

Period:
	.ascii ".\0"

SpNoun:
	.space 20

SpVerb:
	.space 20

SpPrep:
	.space 20

SpNoun2:	
	.space 20	


.text
.global _start

_start:

	mov $Silly, %rdx
	call PrintCString

	mov $Noun, %rdx
	call PrintCString
	mov $SpNoun, %rdx
	mov $20, %rcx
	call ScanCString
	call ClearScreen	

	mov $Verb, %rdx
	call PrintCString
	mov $SpVerb, %rdx
	mov $20, %rcx
	call ScanCString
	call ClearScreen

	mov $Prep, %rdx
	call PrintCString
	mov $SpPrep, %rdx
	mov $20, %rcx
	call ScanCString
	call ClearScreen

	mov $Noun2, %rdx
	call PrintCString
	mov $SpNoun2, %rdx
	mov $20, %rcx
	call ScanCString
	call ClearScreen
	
	mov $Final, %rdx
	call PrintCString
	
	mov $SpNoun, %rdx
	call PrintCString
	mov $Space, %rdx
	call PrintCString

	mov $SpVerb, %rdx
        call PrintCString
        mov $Space, %rdx
        call PrintCString
	
	mov $SpPrep, %rdx
        call PrintCString
        mov $Space, %rdx
        call PrintCString

	mov $SpNoun2, %rdx
	call PrintCString
	mov $Period, %rdx
	call PrintCString

	mov $NewLine, %rdx
        call PrintCString
	

	call EndProgram
