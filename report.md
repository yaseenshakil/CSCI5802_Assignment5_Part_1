# Part 1 Report 

## #1: CT_CONSTRUCTOR_THROW 
### Type of bug
Bad Practice
### Reason for bug 
The constructor throws an Exception and is therefore vulnerable to Finalizer attacks
### Bug-Causing code
Line 18 in BankAccount.java
### Bug analysis 
This bug stems from the fact that the constructor would throw an exception if the name provided is null which exposes the 
program to finalizer attacks. Essentially, if a null name parameter is provided to the Analyzer class instantiation, an exception would 
be thrown. A fix would be in order to prevent finalizer attacks, however, would not directly break the program as is currently. 
### Code Fix
```java
    public final class BankAccount{
    }

```

## Bug 2: UWF_NULL_FIELD
### Type of bug
Correctness Warning
### Reason for bug
The OutputStream object created, which will later be used by a function is set to NULL on instantiation and is never modified from NULL
### Bug-Causing Code 
Line 14 in BankAccount.java
### Bug analysis
This bug is a real defect since an object that is later utilized and referenced is set to NULL and never modified. This would 
cause program failures and exceptions if it is not caught
### Code Fix
```java
// If we were trying to send the OutputStream to a file titled "receipt.txt", we could declare it with the following 
OutputStream receipt = new FileOutputStream("receipt.txt");

```


## Bug 3: DM_DEFAULT_ENCODING
### Type of bug: 
Internalization
### Reason for bug
This bug arises from a string to byte conversion that assumes the default platform encoding
### Bug-Causing Code
Line 32 in BankAccount.java
### Bug analysis
This bug is a real defect and will be noticeable when the application on different systems since different systems use different encodings. 
As a result, special characters i.e. emojis will not be represented properly. This needs to be atoned for cross-platform flexibility. 
### Code Fix
```java
// Modify the line: this.receipt.write(receiptData.getBytes()) to the following: 
// this.receipt.write(receiptData.getBytes("UTF-8"));
```


## Bug 4: VO_VOLATILE_INCREMENT
### Type of bug:
Multithreaded correctness 
### Reason for bug
A volatile field, in this case, ageOfAccount was incremented 
### Bug analysis
This bug is a defect since a volatile field is incremented which is a non-atomic operation. If the volatile field is incremented or decremented in this fashion, 
increments or decrements could be lost. 
### Code Fix 
```java
public class BankAccount{
    private int ageOfAccount; 
    
    public synchronized incrementAgeOfAccount(){
        ageOfAccount++;
    }
}
```

## Bug 5: URF_UNREAD_FIELD
### Type of bug:
Performance 
### Reason for bug
The field typeOfAccount is never read
### Bug analysis
This bug is not necessarily a defect since the program would operate as expected however the field typeOfAccount is never read or accessed. 
As is, the program would not fail but we can remove the typeOfAccount field if we don't use it to reduce code overhead and improve code maintenance and
readability.


## Bug 6: UC_USELESS_VOID_METHOD
### Type of bug:
Dodgy Code
### Reason for bug
The function appears to not do anything functionally significant and therefore appears redundant
### Bug analysis
This bug is not a defect. Instead, it highlights redundant code that does not appear to serve a relevant purpose. The function could be removed to improve 
readability and code maintainability. 


