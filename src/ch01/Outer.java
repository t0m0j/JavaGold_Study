package ch01;

public class Outer {
    // 親（Outer）の個人的な持ち物（インスタンス変数）
    String personalItem = "親の財布";
    
    // 親族の共有の持ち物（static変数）
    static String sharedItem = "家のテレビ";

    // ==========================================
    // 1. 普通のインナークラス（親にべったり甘える子）
    // ==========================================
    class Inner {
        public void checkItems() {
            System.out.println("【普通のインナークラスからのアクセス】");
            // 親と一体化しているので、親の個人的な持ち物も使える
            System.out.println("個人的な持ち物: " + personalItem); 
            System.out.println("共有の持ち物: " + sharedItem);
            System.out.println("-------------------------");
        }
    }

    // ==========================================
    // 2. staticネストクラス（自立した子）
    // ==========================================
    static class StaticInner {
        public void checkItems() {
            System.out.println("【staticネストクラスからのアクセス】");
            // 【重要】自立しているので、親の個人的な持ち物には触れない！
            // 以下のコメントアウト（//）を外すとコンパイルエラー（赤線）になります。
            // System.out.println("個人的な持ち物: " + personalItem); 

            // 共有の持ち物なら使える
            System.out.println("共有の持ち物: " + sharedItem);
            System.out.println("-------------------------");
        }
    }

    // ==========================================
    // 実行用メソッド（ここでそれぞれの「子」を誕生させます）
    // ==========================================
    public static void main(String[] args) {
        
        // パターンA：普通のインナークラスを作る場合
        // まず親（Outer）を new して、その親から .new Inner() で子を作る
        Outer parent = new Outer();
        Outer.Inner sweetChild = parent.new Inner();
        sweetChild.checkItems();

        // パターンB：staticネストクラスを作る場合
        // 親を new せずに、直接 Outer.StaticInner を new できる
        Outer.StaticInner independentChild = new Outer.StaticInner();
        independentChild.checkItems();
        
    }
}