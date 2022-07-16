// いったいなんのロジックだろう...？

int d = 0;
d = p1 + p2;
d = d - ((d1 + d2) / 2);
if (d < 0) {
  d = 0;
}

// 意図が伝わる名前をつけよう

int damageAmount = 0;
damageAmount = playerArmPower + playerWeaponPower;
damageAmount = damageAmount - ((enemyBodyDefence + enemyArmorDefence) / 2);
if (damageAmount < 0) {
  damageAmount = 0;
}