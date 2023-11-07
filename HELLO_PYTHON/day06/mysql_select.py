# 인터넷 검색해서 8줄짜리 mysql 접속해서 콘솔창에 띄우기
import pymysql

conn = pymysql.connect(host='localhost', user='root',port=3305, password='python', db='python', charset='utf8')
 
curs = conn.cursor()

sql = 'select * from emp'
curs.execute(sql)
table = curs.fetchall()
print(table)
conn.commit
for row in curs:
    print(row)
    
conn.close()