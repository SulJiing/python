from flask import Flask
from flask.templating import render_template

app = Flask(__name__)

@app.route('/') # 아무것도 없어도 이쪽으로 옮겨짐 = welcompage
@app.route('/emp_list')
def emp_list():
    return render_template("emp_list.html")

if __name__ == '__main__':
    app.run(debug=True) #이거 붙이면 서버 껐다 켰다 안해도 됨
