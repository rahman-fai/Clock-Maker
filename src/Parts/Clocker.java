package Parts;

public class Clocker {

    public static void main(String[] args) {

        /*old user input
         * Scanner user = new Scanner(System.in);
         * System.out.println("Enter Escapment");
         * int e = user.nextInt();
         * System.out.println("Enter min ");
         * int min = user.nextInt();
         * System.out.println("Enter max ");
         * int max = user.nextInt();
         * System.out.println("Enter mod ");
         * double mod = user.nextDouble();
         * System.out.println("Enter bph ");
         * double bph = user.nextDouble();
         * System.out.println("Enter pin ");
         * double pin = user.nextDouble();
         * user.close();
         * Clocker c = new Clocker();
         * c.makeTrain(min, max, mod, bph, e, pin);
         */
        startUp();

    }

    public static void startUp() {
        MyFrame frame = new MyFrame();

    }

    public void makeTrain(int min, int max, double mod, int BpH, int E, double pinD) {// E=Escapment wheel;

        for (double C = max; C >= min; C--) {
            for (double T = max; T >= min; T--) {
                for (double t = max; t >= min; t--) {
                    for (double f = max; f >= min; f--) {
                        if ((C * T) / (t * f) == 60.0) {
                            for (double F = max; F >= min; F--) {
                                for (double e = max; e >= min; e--) {
                                    if (((C * T * F * 2 * E) / (t * f * e)) % 60 == 0 && ((C * T) / (t * f)) == 60.0) {
                                        if ((F / e) == ((double) BpH / (60.0 * 2 * (double) E))) {
                                            if (C > T && C > t && C > f && C > e && C > F) {
                                                if (F * mod > 72) {
                                                    Double[] train = new Double[6];

                                                    train[0] = C;
                                                    train[1] = t;
                                                    train[2] = T;
                                                    train[3] = f;
                                                    train[4] = F;
                                                    train[5] = e;
                                                    int sCount = 0;
                                                    for (int i = 4; i > 0; i = i - 2) {// checks wheels
                                                        double x = (train[i - 1] * mod) / 2 + (train[i - 2] * mod) / 2;// distance between pinion and wheel (touching)
                                                        if (x - ((train[i] * mod) / 2 + mod + pinD / 2) >= 1) {// if distance between + tooth height(mod) > larger  wheel + pin diameter
                                                            sCount++;
                                                        }
                                                    }
                                                    if (sCount == 2) {
                                                        System.out.println("C: " + train[0] + "    t: " + train[1]
                                                                + "    T: " + train[2] + "    f: " + train[3]
                                                                + "    F: " + train[4] + "    30e: " + train[5]);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    }

}
