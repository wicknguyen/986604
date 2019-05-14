/*jshint esversion: 6 */


var bankingAccount = function() {
    "use strict";
    var accountInfoList = [];
    function Account(name, deposit) {
        this.name = name;
        this.deposit = deposit;
    }

    var createAccount = function () {
        let name = document.getElementById("name").value;
        let deposit = document.getElementById("deposit").value;
        let newAccount = new Account(name, deposit);
        accountInfoList.push(newAccount);
        showAccountInfo(accountInfoList);
    };

    function showAccountInfo(accountlist) {
        let result = "";
        for (var account of accountlist) {
            result += "Account name: " + account.name + " Balance: " + account.deposit + "\n";
        }
        document.getElementById("result").value = result;
    }

    document.getElementById("create").onclick = createAccount;
};

window.onload = bankingAccount;
