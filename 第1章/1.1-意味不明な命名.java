// 技術駆動命名

class MemoryStateManager {
  void ChangeIntValue01(int ChangeValue) {
    intValue01 -= ChangeValue;
    if (intValue01 < 0) {
      intValue01 = 0;
      updateState02Flag();
    }
  }
}

// 連番命名

class Class001 {
  void method001();
  void method002();
  void method003();
}