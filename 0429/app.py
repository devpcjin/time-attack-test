from datetime import datetime

from flask import Flask, render_template, jsonify, request
from pymongo import MongoClient

app = Flask(__name__)

client = MongoClient("mongodb://localhost:27017/")
db = client.test


@app.route('/')
def index():
    return render_template('index.html')

@app.route('/detail/<idx>')
def detail(idx):

    return render_template("detail.html")

@app.route('/post', methods=['POST'])
def save_post():
    title_receive = request.form['title_give']
    pw_receive = request.form['pw_give']
    content_receive = request.form['content_give']

    idx_count = db.memo.estimated_document_count({})
    if idx_count == 0:
        idx = 1
    else:
        idx = db.memo.find_one(sort=[("idx",-1)])['idx']+1

    doc = {
        'idx':idx,
        'title':title_receive,
        'pw':pw_receive,
        'content':content_receive,
        'reg_date':datetime.now()
    }
    db.memo.insert_one(doc)

    return {"result": "success","msg":"저장 완료!"}


@app.route('/post', methods=['GET'])
def get_post():
    posts = 0
    posts = list(db.memo.find({}, {'_id': False}))
    return jsonify({"posts": posts})


@app.route('/post', methods=['DELETE'])
def delete_post():
    idx = request.args.get('idx')
    db.memo.delete_one({'idx': int(idx)})
    return {"result": "success"}


if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000)