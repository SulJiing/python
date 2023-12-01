import pymysql

class daostock:
    def __init__(self):
        self.conn = pymysql.connect(host='localhost', user='root',port=3305, password='python', db='python', charset='utf8')
 
        self.curs = self.conn.cursor(pymysql.cursors.DictCursor)
        
        
    def selectArr(self,s_name):
        sql = f"select * from stock where s_name= '{s_name}'"
        self.curs.execute(sql)
        list = self.curs.fetchall()
        return list
    
    def __del__(self):
        self.curs.close()
        self.conn.close()
        
if __name__ == '__main__':
    ds = daostock()
    list = ds.selectArr("삼성전자")
    # print(list)