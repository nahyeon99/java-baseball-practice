package baseball.domain;

import baseball.generator.BaseballNumbersGenerator;

public class Computer {
    private final BaseballNumbersGenerator numbersGenerator;

    public Computer(BaseballNumbersGenerator numbersGenerator) {
        this.numbersGenerator = numbersGenerator;
    }

    private BaseballNumbers generate() {
        return numbersGenerator.generate();
    }
}
