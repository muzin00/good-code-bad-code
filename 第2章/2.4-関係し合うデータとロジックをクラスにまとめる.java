// 単なる変数として用意されたヒットポイント

int hitPoint;

// どこかに書かれるヒットポイント減少ロジック

hitPoint =  hitPoint - damageAmount;
if (hitPoint < 0) {
  hitPoint = 0;
}

// どこかに書かれるヒットポイント回復ロジック

hitPoint = hitPoint + recoveryAmount;
if (999 < hitPoint) {
  hitPoint = 999;
}

// クラスにすると強く関係するデータとロジックをまとめられる

// ヒットポイント(HP)を表現するクラス
class HitPoint {
  private static final int MIN = 0;
  private static final int MAX = 999;
  final int value;

  HitPoint(final int value) {
    if (value < MIN) throw new IllegalArgumentException(MIN + "以上を指定してください");
    if (MAX < value) throw new IllegalArgumentException(MAX + "以下を指定してください");
    this.value = value;
  }

  // ダメージを受ける
  HitPoint damage(final int damageAmount) {
    final int damaged = value - damageAmount;
    final int corrected = damaged < MIN ? MIN : damaged;
    return new HitPoint(corrected);
  }

  // 回復する
  HitPoint recover(final int recoevryAmount) {
    final int recovered = value + recoevryAmount;
    final int corrected = MAX < recovered ? MAX : recovered;
    return new HitPoint(corrected);
  }
}
