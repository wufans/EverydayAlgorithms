# -*- coding: utf-8 -*-
"""
Created on Tue Aug 21 23:18:18 2018

@author: WuFan

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
"""
class Solution:
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
# =============================================================================
#         if not s:return True
# #        dic = {"(":")",
# #               "[":"]",
# #               "{":"}"}
#         left_bra = ["(","[","{"]
#         right_bra = [")","]","}"]
#         if s[0] not in left_bra: return False
#         if len(s)%2 != 0: return False
#         Flag = True
#         while(Flag):
# =============================================================================
        stack = []
        dict = {"]":"[", "}":"{", ")":"("}
        for char in s:
            if char in dict.values():
                stack.append(char)
            elif char in dict.keys():
                if stack == [] or dict[char] != stack.pop():
                    return False
            else:
                return False
        return stack == []
            
# =============================================================================
#         pairs = {'(': ')', '[': ']', '{': '}'}
#         stack = []
#         for c in s:
#             if c in pairs:
#                 stack.append(c)
#             else:
#                 if len(stack) == 0: return False
#                 top = stack.pop()
#                 if top not in pairs or pairs[top] != c: return False
#         return len(stack) == 0
# =============================================================================
            
        
test = Solution()
print(test.isValid(""))
