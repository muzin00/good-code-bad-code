// 何重にもネストしたロジック

// 生存しているか判定
if (0 < member.hitPoint) {
  // 行動可能かを判定
  if (member.canAct) {
    // 魔法力が残存しているかを判定
    if (magic.costMagicPoint <= member.magicPoint) {
      member.consumeMagicPoint(magic.costMagicPoint);
      member.chant(magic);
    }
  }
}

// 巨大なネスト

if (条件) {
  //
  // 数十〜数百行に及ぶ何かの処理
  //
  if (条件) {
    //
    // 数十〜数百行に及ぶ何かの処理
    //
    if (条件) {
      //
      // 数十〜数百行に及ぶ何かの処理
      //
      if (条件) {
        //
        // 数十〜数百行に及ぶ何かの処理
        //
      }
    }
    if (条件) {
      //
      // 数十〜数百行に及ぶ何かの処理
      //
    }
  }
  if (条件) {
    //
    // 数十〜数百行に及ぶ何かの処理
    //
  }
}