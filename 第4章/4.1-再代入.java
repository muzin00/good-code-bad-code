class Test {
  // 変数tmpへの度重なる再代入

  // int damage() {
  //   // メンバーの腕力と武器性能が基本攻撃力
  //   int tmp = member.power() + member.weaponAttack();
  //   // メンバーのスピードで攻撃力を補正
  //   tmp = (int)(tmp * (1f + member.speed() / 100f));
  //   // 攻撃力から敵の防御力を差し引いたのがダメージ
  //   tmp = tmp - (int)(enemy.defence / 2);
  //   // ダメージ値が負数にならないように補正
  //   tmp = Math.max(0, tmp);
  // }

  // 個別の不変なローカル変数に変更

  int damage() {
    final int basicAttackPower = member.power() + member.weaponAttack();
    final int finalAttackPower = (int)(basicAttackPower * (1f + member.speed() / 100f));
    final int reduction = (int)(enemy.defence() / 2);
    final int damage = Math.max(0, finalAttackPower - reduction);
    
    return damage;
  }

  // 引数productPriceへ再代入している

  // void addPrice(int productPrice) {
  //   productPrice = totalPrice + productPrice;
  //   if (MAX_TOTAL_PRICE < productPrice) {
  //     throw new IllegalArgumentException("購入金額の上限を超えています。");
  //   }
  // }

  // 引数にfinalを付与して不変にする

  void addPrice(final int productPrice) {
    final int increasedTotalPrice = totalPrice + productPrice;
    if (MAX_TOTAL_PRICE < increasedTotalPrice) {
      throw new IllegalArgumentException("購入金額の上限を超えています。");
    } 
  }
}
