# QA

## Queue with two stacks

Implement a queue with two stacks so that each queue operations takes a constant amortized number of stack operations.

`Hint`: If you push elements onto a stack and then pop them all, they appear in reverse order. If you repeat this process, they're now back in order.

## Stack with max

Create a data structure that efficiently supports the stack operations (push and pop) and also a return-the-maximum operation. Assume the elements are real numbers so that you can compare them.

`Caution`: Remember we need to pop some element out, so if you just keep a value `current max`, you will cry when it pop out.

`Hint`: Use two stacks, one to store all of the items and a second stack to store the maximums.

`Related Link`:

+ https://www.geeksforgeeks.org/tracking-current-maximum-element-in-a-stack/

## Java generics

Explain why Java prohibits generic array creation.

`Hint`: to start, you need to understand that Java arrays are covariant but Java generics are not: that is, ```String[]``` is a subtype of ```Object[]```, but ```Stack<String>``` is not a subtype of ```Stack<Object>```.

`Related Link`:

+ https://www.simplexacode.ch/en/blog/2018/08/the-problem-with-creating-generic-arrays/

+ https://www.tothenew.com/blog/why-is-generic-array-creation-not-allowed-in-java/
