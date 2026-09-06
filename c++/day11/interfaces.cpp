#include<iostream>
using namespace std;

class IPayment {
public:
    virtual void payment(double amt) = 0;
    virtual ~IPayment() = default;

};

class Stripe : public IPayment{
public:
    void payment(double amt) override{
        cout << amt << " From stripe" << endl;
    }
};

class Paypal : public IPayment{
public: 
    void payment(double amt) override{
        cout << amt << " From paypal" <<endl;
    }
};

class Store { 
    IPayment *pay;
    public:
        Store(IPayment *pay) : pay(pay){
            cout << "Payment done" << endl;
        }
        void checkout(double amt){
            pay -> payment(amt);
        }
};




int main(){
    Stripe p1;
    Paypal p2;
    Store s1(&p1);
    s1.checkout(99);
    Store s2(&p2);
    s2.checkout(8);

    return 0;
}
