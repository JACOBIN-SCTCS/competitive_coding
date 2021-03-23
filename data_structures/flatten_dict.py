


ans = dict()

def solve(key,dictionary,relative):
    
    if(type(dictionary[relative])!=type(dict())):
        ans[key] = dictionary[relative]
    
    else:
        next_key = key + "."
        for k in dictionary[relative].keys():
            solve(next_key+k,dictionary[relative],k)


def main():

    d = { 
            "Key1" : "1",
            "Key2" : {
                        "a" : "2",
                        "b" : "3",
                        "c" : {
                                "d" : {"x":{"y": "10"}},
                                "e" : "1"
                              }
                     }
          
            }
    for k in d.keys():
        solve(k,d,k)
    
    print(ans)
    


if __name__=="__main__":
    main()





