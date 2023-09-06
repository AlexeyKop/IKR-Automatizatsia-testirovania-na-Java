public class MathService {

    public Pair getAnswer(int a, int b, int c) throws NotFoundAnswerException {
        int d = b * b - 4 * a * c;
        if (d < 0) {
            throw new NotFoundAnswerException("Корни не могут быть найдены");
        }
        if (d == 0) {
            Double x = (double) ((-b) / (2 * a));
            return new Pair(x,x);
        }
        if (d > 0) {
            Double x1 = (-b + Math.sqrt(d)) / (2 + a);
            Double x2 = (-b - Math.sqrt(d)) / (2 + a);
            return new Pair(x1, x2);
        }
        return null;
    }
}
