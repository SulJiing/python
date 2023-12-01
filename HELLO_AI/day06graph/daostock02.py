import pymysql
import numpy as np

class daostock02:
    def __init__(self):
        self.conn = pymysql.connect(host='localhost', user='root',port=3305, password='python', db='python', charset='utf8')
 
        self.curs = self.conn.cursor(pymysql.cursors.DictCursor)
        
        
    def selectArr(self,s_name):
        sql = f"select * from stock where s_name= '{s_name}'"
        self.curs.execute(sql)
        list = self.curs.fetchall()
        
        arr = []
        for i in list:
            price = (i['price'])
            arr.append(price)
        return arr
    
    def selectArrN(self,s_name):
        sql = f"select * from stock where s_name= '{s_name}'"
        self.curs.execute(sql)
        list = self.curs.fetchall()
        
        arr = []
        for i in list:
            price = (i['price'])
            arr.append(price)
        return np.array(arr)   
    
    def selectSNames(self):
        sql = " SELECT DISTINCT s_name FROM stock"
        self.curs.execute(sql)
        list = self.curs.fetchall()
        
        arr = []
        for i in list:
            names = i['s_name']
            arr.append(names)
        return arr 
    
    def __del__(self):
        self.curs.close()
        self.conn.close()
        
if __name__ == '__main__':
    ds = daostock02()
    arr = ds.selectSNames()
    print(arr)