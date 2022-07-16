import java.util.Currency;

// 必ずコンストラクタで初期化する
// コンストラクタで正常値のみが確実に設定されるしくみ
// finalで不変にする
// Money型だけ渡せるようにする
// メソッドにもバリデーションを追加する

class Money {
  final int amount;
  final Currency currency;

  Money(int amount, Currency currency) {
    if (amount < 0) {
      throw new IllegalArgumentException("金額が0以上ではありません。");
    }
    if (currency == null) {
      throw new NullPointerException("通貨を指定してください。");
    }

    this.amount = amount;
    this.currency = currency;
  }

  Money add(final Money other) {
    if (!currency.equals(other.currency)) {
      throw new IllegalArgumentException("通貨単位が違います。");
    }

    final int added = amount + other.amount;
    return new Money(added, currency);
  }
}
