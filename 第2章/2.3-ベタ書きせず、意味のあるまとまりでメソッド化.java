// 意味のあるまとまりでメソッド化しよう

// プレイヤーの攻撃力を合算する
int sumUpPlayerAttackPower(int playerArmPower, int playerWeaponPower) {
  return playerArmPower + playerWeaponPower;
}

// 敵の防御力を合算する
int sumUpEnemyDefence(int enemyBodyDefence, int enemyArmorDefence) {
  return enemyBodyDefence + enemyArmorDefence;
}

// ダメージ量を評価する
int estimateDamage(int totalPlayerAttackPower, int totalEnemyDefence) {
  int damageAmount = totalPlayerAttackPower - (totalEnemyDefence / 2);
  if (damageAmount < 0) {
    return 0;
  }
  return damageAmount;
}

// メソッドを呼び出す形に整理

int totalPlayerAttackPower = sumUpPlayerAttackPower(playerArmPower, playerWeaponPower);
int totalEnemyDefence = sumUpEnemyDefence(enemyBodyDefence, enemyArmorDefence);
int damageAmount = estimateDamage(totalPlayerAttackPower, totalEnemyDefence);