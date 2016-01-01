# you can write to stdout for debugging purposes, e.g.
# print "this is a debug message"

def solution(A):
    max_blocks = 0
    peak_idx = list()
    for i in range (1, len(A) - 1):
        if A[i - 1] < A[i] and A[i + 1] < A[i]:
            peak_idx.append(i)
    if len(peak_idx) == 0:
        return 0
    #print "Peak_idx: ", peak_idx
    for block_size in range (len(A), 0, -1):
        #print "Block size: ", block_size
        didnt_work = 0
        block_start = 0
        while block_start < len(A):
            #attempt to find an index in peak_idx between block_start and block_end block_start + block_size
            #print A[block_start:block_start + block_size]
            search_start = 0
            search_end = len(peak_idx) - 1
            while search_end - search_start > 1:
                #print "Search start ", search_start
                #print "Search end: ", search_end
                #print peak_idx[search_start:search_end+1]
                if peak_idx[search_start] < block_start:
                    search_start = (search_end + search_start)/2
                    #print "Search start ", search_start
                    #print "Search end: ", search_end
                    #print peak_idx[search_start:search_end+1]
                elif peak_idx[search_end] > block_start + block_size:
                    search_end = (search_end + search_start)/2
                    #print "Search start ", search_start
                    #print "Search end: ", search_end
                    #print peak_idx[search_start:search_end+1]
                else:
                    break
            if peak_idx[search_start] >= block_start and peak_idx[search_start] < block_start + block_size:
                block_start = block_start + block_size
            elif peak_idx[search_end] >= block_start and peak_idx[search_end] < block_start + block_size:
                block_start = block_start + block_size
            else:
                #print "Binary search failed for block size: ", block_size
                #print "Block start: ", block_start
                #print "Block end: ", block_start + block_size
                didnt_work = 1
                break
        if not didnt_work:
            if len(A) % block_size == 0:
                max_blocks = len(A) / block_size
            else:
                max_blocks = len(A)/block_size + 1
        #print "new max blocks of: ", max_blocks
    return max_blocks