import pymysql

class daostock:
    def __init__(self):
        self.conn = pymysql.connect(host='localhost', user='root',port=3305, password='python', db='python', charset='utf8')
 
        self.curs = self.conn.cursor(pymysql.cursors.DictCursor)
        
    def selectList(self):
        sql = 'select * from stock'
        self.curs.execute(sql)

        list = self.curs.fetchall()
        return list
    
    def insert(self,s_name,price,s_code,y_md):
        wc = int(price.replace(',',''))
        sql = f"insert into stock (s_name, price, s_code, ymd) values ('{s_name}','{wc}','{s_code}','{y_md}')"
        print(sql)
        
        cnt = self.curs.execute(sql)
        self.conn.commit()
        return cnt
        
if __name__ == '__main__':
    ds = daostock()
    vo = ds.selectList()
    print(vo)