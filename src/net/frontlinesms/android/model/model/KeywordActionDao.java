/**
 * 
 */
package net.frontlinesms.android.model.model;

import java.util.List;

import android.database.Cursor;

import net.frontlinesms.android.db.BaseDbAccessObject;

import android.content.ContentResolver;
import net.frontlinesms.android.db.FrontlineSmsSqliteHelper;

/**
 * @author aga
 */
public class KeywordActionDao extends BaseDbAccessObject implements IKeywordActionDao {

    public KeywordActionDao(ContentResolver contentResolver) {
		super(contentResolver);
	}

	@Override
	public void addAction(KeywordAction action) {
		super.save(action);
	}

	@Override
	public KeywordAction[] getActions(String messageContent) {
		KeywordAction example = new KeywordAction();
		example.setKeyword(KeywordAction.getKeyword(messageContent));
		return super.get(example).toArray(new KeywordAction[0]);
	}

	@Override
	public List<KeywordAction> getKeywords() {
		List<KeywordAction> keywordList = super.get(KeywordAction.class);
        return keywordList;

        /*
		TreeSet<String> keywords = new TreeSet<String>();
		for(KeywordAction action : keywordList) {
			keywords.add(action.getKeyword());
		}
		return keywords.toArray(new String[0]);
		*/
	}

    @Override
    public Cursor getKeywordsCursor() {
        return super.getCursor(KeywordAction.class);
    }

    @Override
	protected String getBaseUri() {
		return FrontlineSmsSqliteHelper.CONTENT_URI;
	}
}