package baseball.domain;

import baseball.util.RandomNumbersGenerator;

public class Computer {
    private final RandomNumbersGenerator randomNumbersGenerator;

    public Computer(RandomNumbersGenerator randomNumbersGenerator) {
        this.randomNumbersGenerator = randomNumbersGenerator;
    }

    public BaseballNumbers createRandomNumbers() {
        return BaseballNumbers.computerOf(randomNumbersGenerator.generate());
    }
}
