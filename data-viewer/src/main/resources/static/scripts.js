$("#btnGetCustomerData").click(function () {
    $('#errorMessage').hide();
    $('#data').hide();
    $.get("/data/" + $("#customerId").val(), function (data, status) {
        $('#custId').text(data.id);
        $('#customerBalance').text(data.balance);
        var cards = "";
        var cardNum = 1;
        data.accounts.forEach(account = > {
            cards += generateCard(account, cardNum);
        cardNum++;
    })
        $('#accountsTable').html(cards);
        $('#data').show();
    }).fail(function (data) {
        $('#errorMessage').text(data.responseJSON.message);
        $('#errorMessage').show();
    });
});

function generateCard(account, i) {
    return '<div class="card">\n' +
        '                <div class="card-header" id="heading' + i + '">\n' +
        '                    <h5 class="mb-0">\n' +
        '                        <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapse' + i + '" aria-expanded="true" aria-controls="collapse' + i + '">\n' +
        '                            ' + account.name + '\n' +
        '                        </button>\n' +
        '                    </h5>\n' +
        '                </div>\n' +
        '\n' +
        '                <div id="collapse' + i + '" class="collapse" aria-labelledby="heading' + i + '" data-parent="#accountsTable">\n' +
        '                    <div class="card-body">\n' +
        '                        <div class="row">\n' +
        '                            <div class="col-sm">\n' +
        '                                <b><label for="accountName">Account name: </label></b>\n' +
        '                                <span id="accountName">' + account.name + '</span>\n' +
        '                            </div>\n' +
        '                            <div class="col-sm">\n' +
        '                                <b><label for="accountBalance">Account balance: </label></b>\n' +
        '                                <span id="accountBalance">' + account.balance + '</span>\n' +
        '                            </div>\n' +
        '                        </div>\n' +
        '                        <hr/>\n' +
        '                        <h3>Transactions:</h3>\n' +
        generateTransactionsTable(account.transactions) +
        '                    </div>\n' +
        '                </div>\n' +
        '            </div>';

    return result;
}

function generateTransactionsTable(transactions) {
    var result = '<table class="table">\n' +
        '                            <thead>\n' +
        '                            <tr>\n' +
        '                                <th scope="col">ID</th>\n' +
        '                                <th scope="col">Time</th>\n' +
        '                                <th scope="col">Amount</th>\n' +
        '                            </tr>\n' +
        '                            </thead>\n' +
        '                            <tbody>\n';

    transactions.forEach(transaction = >
    result += '<tr>\n' +
        '                                <th scope="row">' + transaction.id + '</th>\n' +
        '                                <td>' + formatTime(transaction.time) + '</td>\n' +
        '                                <td>' + transaction.amount + '</td>\n' +
        '                            </tr>\n';
)
    result += '</tbody>\n' +
        '                        </table>';

    return result;
}

function formatTime(timestamp) {
    var a = new Date(timestamp);
    var months = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
    var year = a.getFullYear();
    var month = months[a.getMonth()];
    var date = a.getDate();
    var hour = a.getHours();
    var min = a.getMinutes();
    var sec = a.getSeconds();
    var time = date + ' ' + month + ' ' + year + ' ' + hour + ':' + min + ':' + sec;
    return time;
}