# Linear Search

Goal: Find a particular value in an array.

We have an array of generic objects. With linear search, we iterate over all the objects in the array and compare each one to the object we're looking for. If the two objects are equal, we stop and return the current array index. If not, we continue to look for the next object as long as we have objects in the array.

## An example

Let's say we have an array of numbers `[5, 2, 4, 7]` and we want to check if the array contains the number `2`.

We start by comparing the first number in the array, `5`, to the number we're looking for, `2`. They are obviously not the same, and so we continue to the next array element.

We compare the number `2` from the array to our number `2` and notice they are equal. Now we can stop our iteration and return 1, which is the index of the number `2` in the array.
