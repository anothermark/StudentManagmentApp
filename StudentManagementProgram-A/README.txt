This Student Management Application, a small app of 
many pieces, was built using Eclipse and its 
WindowBuilder, limits enrollment to five (5) 
students and consists of six (6) .java files 
and six (6) text files. It is unconventional 
in several ways because, among other 
things, it does not rely on a database to store state, 
but simply stores Student objects in an ArrayList 
which is repeatedly serialized and deserialized; 
this is the application's primary list and it is 
central to the application. When the first student 
record is added, that binary ArrayList of (anonymous) 
Student objects is stored in your directory and 
called returnedStudentArrayListSER.

Working in tandem with returnedStudentArrayListSER 
is aListForComboSER, likewise a binary file for 
listing selectable JComboBox options of students' 
last names which are used to retrieve and display 
data for a particular student. JComboBox selections 
are ordered by a student's last name. Accordingly, 
a last name is central to addition, retrieval and 
updates of student records.

Furthermore, when student records are sorted (at 
least two required) the binary sortedSERList 
is generated.

When adding (and updating) a student record, that 
data is also saved to a text file such as 
0StudentFILE.txt, of which there are five.
 
The app is not thread safe by any means, 
but that's unnecessary under the circumstances. 
It's also brittle and it doesn't take much to 
crash the program. Now, if the user behaves and 
enters data like a polite, normal person it 
should work fine. On the other hand, a nefarious 
miscreant lobbing grenades in there could easily 
bring it to its knees. The tweaks required to fix 
all bugs are seemingly endless, but at some point 
I had to move on. So, if it does crash beyond hope 
my suggestion is to simply delete the app, fork 
another copy and start over from scratch. 

Regards.


