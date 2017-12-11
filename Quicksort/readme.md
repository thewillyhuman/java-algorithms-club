# Quicksort
 
Goal: Sort an array from low to high (or high to low).
 
Quicksort is one of the most famous algorithms in history. It was invented way back in 1959 by Tony Hoare, at a time when recursion was still a fairly nebulous concept.
 
Here's how it works. When given an array, `quicksort()` splits it up into three parts based on a "pivot" variable. Here, the pivot is taken to be the element in the middle of the array (later on you'll see other ways to choose the pivot).

All the elements less than the pivot go into a new array called `less`. All the elements equal to the pivot go into the `equal` array. And you guessed it, all elements greater than the pivot go into the third array, `greater`. This is why the generic type `T` must be `Comparable`, so we can compare the elements with `<`, `==`, and `>`.

Once we have these three arrays, `quicksort()` recursively sorts the `less` array and the `greater` array, then glues those sorted subarrays back together with the `equal` array to get the final result.