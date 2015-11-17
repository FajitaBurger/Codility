# you can write to stdout for debugging purposes, e.g.
# print "this is a debug message"

#note this problem doesn't allow empty slices unlike the sample problem in the lecture notes

def solution(A):
    max_slice = -1000000
    max_local_slice = -1000000
    for num in A:
        if (max_local_slice + num) < num:
            max_local_slice = num
        else:
            max_local_slice = max_local_slice + num
        if max_local_slice > max_slice:
            max_slice = max_local_slice
    return max_slice