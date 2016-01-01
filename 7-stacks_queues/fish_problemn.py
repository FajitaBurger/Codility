# you can write to stdout for debugging purposes, e.g.
# print "this is a debug message"

def solution(A, B):
    num_fish = len(A)
    downstream = list()
    fish_idx = 0;
    while fish_idx < len(A):
        if B[fish_idx] == 1:
            downstream.append(A[fish_idx])
            fish_idx = fish_idx + 1
        else:
            if len(downstream) == 0:
                fish_idx = fish_idx + 1
            elif A[fish_idx] > downstream[len(downstream) - 1]:
                against_stream_size = 0
                num_fish = num_fish - 1
                downstream.pop()
            else:
                num_fish = num_fish - 1
                fish_idx = fish_idx + 1
    return num_fish
                