# A8 Card Sorting

# Your readme should include the following information. Each student needs to submit all of this information themselves, even when pair programming. 

## General Information
Programming Partner Name (if you'd like to be graded together):

Other Collaborators (and kudos to helpful members of the class): Jessica

Any references used besides JavaDoc and course materials:
When I created the MergeSortTimer.java class, I realized it wouldn't show any timing results when the input number of cards was greater than 100. In some cases when the number of cards was less than 100, it also didn't show any timing results. After carefully checking that my "while" loop brackets were properly closed and checking the stop conditions to ensure there was no infinite loop to no avail, I asked cursor to help give insights on what was happening. The AI pointed out that my loop wasn't checking for when the elements being compared were equal, thus, causing a secret infinite loop. 

## Assignment Reflection

What did you notice about the differences in runtime across algorithms as you changed the number of cards you were sorting? If you had to split them into "slower" algorithms vs "faster" algorithms, which would you put in each category?
MergeSort was definitely the quickest. It's run time for 160000 inputs was the same as the run time of Selection and Insertion Sort for 10000 inputs. However, I realized it also took up more cpu memory, so depending on the application, either MergeSort or (Insertion and/or Selection) sort might be preferred. I suspect QuickSort might be similar to MergeSort because it has similar implementation idea. 

Thus, into categories, I'll group the different algorithms as:
Faster and less space-efficient: MergeSort, QuickSort
Slower and more space-efficient: Insertion, Selection

Please reflect on your experience with this assignment. What was most challenging? What was most interesting?
This assignment was definitely an interesting one for me. I loved thinking through the algorithms myself and felt so much fulfillment and appreciation of the algorithms when I completed them.
The most challenging aspect was figuring out the divide and conquer approach for MergeSort and QuickSort. I left QuickSort unfinished and will talk through it with you during office hours.


## UPDATES
I figured out QuickSort some hours after my initial submission. It has a pretty good time efficiency too but is slightly less efficient than merge sort. I searched why and realized it's because it's worst case is O(n^2) when the partitions are too uneven unlike merge sort whose complexity is always O(nlogn).

## Question
You said calling unsorted.size() isn't a problem right?