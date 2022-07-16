// 丁寧に目的ごとの変数を用意しよう

int totalPlayerAttackPower = playerArmPower + playerWeaponPower;
int totalEnemyDefence = enemyBodyDefence + enemyArmorDefence;
int damageAmount = totalPlayerAttackPower - (totalEnemyDefence / 2);
if (damageAmount < 0) {
  damageAmount = 0;
}