package project.shoesUp2.dao;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import project.shoesUp2.beans.ContentBean;
import project.shoesUp2.mapper.BoardMapper;

import java.util.List;


@Repository
public class BoardDao {

    @Autowired
    private BoardMapper boardMapper;

    public void addContentInfo(ContentBean writeContentBean) {
        for (int i = 0; i <25; i++) {

            boardMapper.addContentInfo(writeContentBean);
        }
    }

    public String getBoardInfoName(int board_info_idx) {
        return boardMapper.getBoardInfoName(board_info_idx);
    }

    public List<ContentBean> getContentList(int board_info_idx, RowBounds rowBounds) {
        return boardMapper.getContentList(board_info_idx, rowBounds);
    }

    public ContentBean getContentInfo(int content_idx) {
        return boardMapper.getContentInfo(content_idx);
    }

    public void modifyContentInfo(ContentBean modifyContentInfo) {
        boardMapper.modifyContentInfo(modifyContentInfo);
    }

    public void deleteContentInfo(int content_idx){
        boardMapper.deleteContentInfo(content_idx);
    }

}
