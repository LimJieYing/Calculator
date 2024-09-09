A simple Polish notation calculator programme

The polish notation involves putting the operator before its argument.
For example, Instead of writing 1+2, in this language you write +12. Only single digits are allowed, and spaces are not allowed.

<EXP> = + <DIGIT> <EXP> | - <DIGIT> <EXP> | * <DIGIT> <EXP> | / <DIGIT> <EXP> | ^ <DIGIT> <EXP> | % <DIGIT> <EXP> | & <EXP> | <DIGIT>  
<DIGIT> = 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | A | B | C | D | E | F
Here EXP represents expressions, where:

+ represents addition.
- represents subtraction.
& represents sum up to the given number (inclusive).
* represents multiplication.
/ represents division.
^ represents exponentiation.
% represents modulus (remainder after division).
DIGIT represents a number from 0 to 15.

