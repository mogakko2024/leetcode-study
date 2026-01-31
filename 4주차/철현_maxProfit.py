class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        buy_price = float("inf")
        profit = 0

        for price in prices:
            buy_price = min(buy_price, price)
            profit = max(profit, price-buy_price)
            
        return profit
