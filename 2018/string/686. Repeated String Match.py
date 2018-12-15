

"""
Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.

For example, with A = "abcd" and B = "cdabcdab".

Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").

Note:
The length of A and B will be between 1 and 10000.
"""


class Solution(object):
    def repeatedStringMatch(self, A, B):
        """
        :type A: str
        :type B: str
        :rtype: int
        """
        # i = 1
        # oldA = A
        # while len(A) <= 3 * len(B) or i < 3:
        #     if B in A:
        #         return i
        #     i += 1
        #     A += oldA
        # return -1

        if B in A:
            return 1

        splittedB = B.split(A)

        if len(splittedB) == 1:
            if B in A + A:
                return 2
            else:
                return -1

        num = 0
        for i in range(1, len(splittedB) - 1):
            if splittedB[i]:
                return -1
            else:
                num += 1

        if splittedB[0]:
            if A.endswith(splittedB[0]):
                num += 1
            else:
                return -1

        if splittedB[-1]:
            if A.startswith(splittedB[-1]):
                num += 1
            else:
                return -1

        return num + 1
