class Solution:
    def deckRevealedIncreasing(self, deck: List[int]) -> List[int]:
        n = len(deck)
        q = deque()
        
        for i in range(n):
            q.append(i)
        
        deck.sort()
        
        res = [0]*n
        
        for card in deck: 
            res[q.popleft()] = card
            
            if q:
                q.append(q.popleft())
                
        return res