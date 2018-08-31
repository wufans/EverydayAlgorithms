# -*- coding: utf-8 -*-
"""
Created on Fri Aug 31 21:28:29 2018

@author: wufan
# =============================================================================
# Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
# 
# Note: For the purpose of this problem, we define empty string as valid palindrome.
# 
# Example 1:
# 
# Input: "A man, a plan, a canal: Panama"
# Output: true
# Example 2:
# 
# Input: "race a car"
# Output: false
# =============================================================================
"""

class Solution:
    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        s = ''.join(e for e in s if e.isalnum()).lower()
        return s==s[::-1]
        
# =============================================================================
#         translator = str.maketrans('', '', string.punctuation + ' ')
#         s = s.translate(translator)
#         s = s.lower() 
#         return s == s[::-1]  
# =============================================================================
