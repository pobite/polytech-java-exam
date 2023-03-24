package com.pobitecoding.project;

import java.util.List;

/**
 * CSV 만드는 거 교수님꺼 참고
 * @author a
 *
 * @param <T>
 */
// 여러 타입 받기 위해 제네릭으로 받음
public interface Data<T> {
    
    void save(List<T> items);
    
    List<T> load();
    
    void backup();
}
