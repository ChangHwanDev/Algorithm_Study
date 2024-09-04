import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Friend {
        int money;
        int stockCount;

        public Friend(int money) {
            this.money = money;
            this.stockCount = 0;
        }

        public void buyStock(int price) {
            int quantity = this.money / price;
            this.money -= quantity * price;
            this.stockCount += quantity;
        }

        public void sellStock(int price) {
            this.money += this.stockCount * price;
            this.stockCount = 0;
        }

        public int totalAssets(int currentPrice) {
            return this.money + this.stockCount * currentPrice;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int money = Integer.parseInt(st.nextToken());
        Friend junhyun = new Friend(money);
        Friend sungmin = new Friend(money);

        st = new StringTokenizer(br.readLine());
        int[] prices = new int[14];
        for (int i = 0; i < 14; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }

        int upDays = 0, downDays = 0;
        for (int i = 0; i < 14; i++) {
            if (junhyun.money >= prices[i]) {
                junhyun.buyStock(prices[i]);
            }

            if (i > 0) {
                if (prices[i] > prices[i - 1]) {
                    upDays++;
                    downDays = 0;
                } else if (prices[i] < prices[i - 1]) {
                    downDays++;
                    upDays = 0;
                } else {
                    upDays = 0;
                    downDays = 0;
                }

                if (upDays >= 3 && sungmin.stockCount > 0) {
                    sungmin.sellStock(prices[i]);
                } else if (downDays >= 3 && sungmin.money >= prices[i]) {
                    sungmin.buyStock(prices[i]);
                }
            }
        }

        int junhyunAssets = junhyun.totalAssets(prices[13]);
        int sungminAssets = sungmin.totalAssets(prices[13]);

        if (junhyunAssets > sungminAssets) {
            System.out.println("BNP");
        } else if (junhyunAssets < sungminAssets) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
    }
}