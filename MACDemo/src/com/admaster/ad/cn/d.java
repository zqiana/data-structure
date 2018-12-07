package com.admaster.ad.cn;


public abstract class d {
    public d() {
        super();
    }

    public abstract String a();

    public abstract String b();

    public abstract String c();

    public abstract String d();

    public abstract String e();

    public abstract String f();

    public abstract String g();

    public abstract String h();

    public abstract String i();

    public abstract boolean j();

    public abstract boolean k();

    public abstract boolean l();

    public abstract String m();

    public abstract String n();

    public abstract String o();

    public abstract String p();

    public final int q() {
        String v0 = this.b();
        int v1 = v0.lastIndexOf(46);
        int v0_1 = v1 >= 0 ? Integer.parseInt(v0.substring(v1 + 1)) : 0;
        return v0_1;
    }

    public final String r() {
        String v0 = this.b();
        return v0.substring(0, v0.lastIndexOf(46)).trim();
    }
}

