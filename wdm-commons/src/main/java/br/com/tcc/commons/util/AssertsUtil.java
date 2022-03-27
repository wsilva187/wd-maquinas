package br.com.tcc.commons.util;

import java.util.Collection;
import java.util.Date;
import java.util.regex.Pattern;

import br.com.tcc.commons.exception.WdmException;
import br.com.tcc.commons.exception.DominioException;

public class AssertsUtil {

	public static final String MENSAGEM_OBJETO_NULO = "objeto.nulo";
	public static final String MENSAGEM_OBJETO_VAZIO = "objeto.vazio";

	private static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private AssertsUtil() {
		super();
	}

	public static boolean isNull(Object obj) {
		return obj == null;
	}

	public static boolean isAllNull(Object... objs) {
		boolean isNull = true;

		for (Object object : objs) {
			isNull = isNull && isNull(object);
		}

		return isNull;
	}

	public static boolean isNotNull(Object obj) {
		return not(isNull(obj));
	}

	public static boolean isAllNotNull(Object... objs) {
		boolean isNull = true;

		for (Object object : objs) {
			isNull = isNull && isNotNull(object);
		}

		return isNull;
	}

	public static boolean not(boolean condicao) {
		return !condicao;
	}

	public static void assertNullDominio(Object obj) throws WdmException {
		assertNullDominio(obj, MENSAGEM_OBJETO_NULO);
	}

	public static void assertNullDominio(Object obj, String message) throws WdmException {
		if (isNull(obj)) {
			throw new DominioException(message);
		}
	}

	public static void assertEmptyDominio(Object obj) throws WdmException {
		assertEmptyDominio(obj, MENSAGEM_OBJETO_VAZIO);
	}

	public static void assertEmptyDominio(Object obj, String message) throws WdmException {
		if (isEmpty(obj)) {
			throw new DominioException(message);
		}
	}

	public static boolean isEmpty(Object obj) {

		if (isNull(obj)) {
			return true;
		}

		if (obj instanceof String) {
			return isEmpty((String) obj);
		}

		if (obj instanceof Collection<?>) {
			return isEmpty((Collection<?>) obj);
		}

		if (obj instanceof Object[]) {
			return isEmpty((Object[]) obj);
		}

		if (obj instanceof byte[]) {
			return isEmpty((byte[]) obj);
		}

		if (obj instanceof Date) {
			return isNull(obj);
		}

		return not(obj instanceof Number);
	}

	public static boolean isAllEmpty(Object... objs) {
		boolean isEmpty = true;

		for (Object object : objs) {
			isEmpty = isEmpty && isEmpty(object);
		}

		return isEmpty;
	}

	private static boolean isEmpty(String str) {
		return str.trim().isEmpty();
	}

	private static boolean isEmpty(Collection<?> lista) {
		return lista.isEmpty();
	}

	private static boolean isEmpty(Object[] array) {
		return array.length == 0;
	}

	private static boolean isEmpty(byte[] array) {
		return array.length == 0;
	}

	public static boolean isNotEmpty(Object obj) {
		return not(isEmpty(obj));
	}

	public static boolean isAllNotEmpty(Object... objs) {
		boolean isEmpty = true;

		for (Object object : objs) {
			isEmpty = isEmpty && isNotEmpty(object);
		}

		return isEmpty;
	}

	public static boolean hasNumberOfItens(Collection<?> collection, int size) {
		return collection.size() == size;
	}

	public static boolean isEmailValido(String email) {

		if (isNull(email)) {
			return false;
		}

		return Pattern.compile(EMAIL_REGEX).matcher(email).matches();
	}

	public static boolean isNotEmailValido(String email) {
		return AssertsUtil.not(isEmailValido(email));
	}

	public static void assertTrueDominio(boolean expression, String mensagem) throws WdmException {
		if (not(expression)) {
			throw new DominioException(mensagem);
		}
	}

	public static void startDateAfterEndDate(Date start, Date end, String message) throws WdmException {
		if (start.after(end)) {
			throw new DominioException(message);
		}
	}

}
