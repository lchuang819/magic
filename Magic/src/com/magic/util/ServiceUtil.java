/*******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *******************************************************************************/
package com.magic.util;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javolution.util.FastMap;

/**
 * Generic Service Utility Class
 */
public class ServiceUtil {

    public static final String module = ServiceUtil.class.getName();
    public static final String resource = "ServiceErrorUiLabels";

    /** A little short-cut method to check to see if a service returned an error */
    public static boolean isError(Map<String, ? extends Object> results) {
        if (results == null || results.get(ModelService.RESPONSE_MESSAGE) == null) {
            return false;
        }
        return ModelService.RESPOND_ERROR.equals(results.get(ModelService.RESPONSE_MESSAGE));
    }

    public static boolean isFailure(Map<String, ? extends Object> results) {
        if (results == null || results.get(ModelService.RESPONSE_MESSAGE) == null) {
            return false;
        }
        return ModelService.RESPOND_FAIL.equals(results.get(ModelService.RESPONSE_MESSAGE));
    }

    /** A small routine used all over to improve code efficiency, make a result map with the message and the error response code */
    public static Map<String, Object> returnError(String errorMessage) {
        return returnProblem(ModelService.RESPOND_ERROR, errorMessage, null, null, null);
    }

    /** A small routine used all over to improve code efficiency, make a result map with the message and the error response code */
    public static Map<String, Object> returnError(List<? extends Object> errorMessageList) {
        return returnProblem(ModelService.RESPOND_ERROR, null, errorMessageList, null, null);
    }

    public static Map<String, Object> returnFailure(String errorMessage) {
        return returnProblem(ModelService.RESPOND_FAIL, errorMessage, null, null, null);
    }

    public static Map<String, Object> returnFailure(List<? extends Object> errorMessageList) {
        return returnProblem(ModelService.RESPOND_FAIL, null, errorMessageList, null, null);
    }

    public static Map<String, Object> returnFailure() {
        return returnProblem(ModelService.RESPOND_FAIL, null, null, null, null);
    }

    /** A small routine used all over to improve code efficiency, make a result map with the message and the error response code, also forwards any error messages from the nestedResult */
    public static Map<String, Object> returnError(String errorMessage, List<? extends Object> errorMessageList, Map<String, ? extends Object> errorMessageMap, Map<String, ? extends Object> nestedResult) {
        return returnProblem(ModelService.RESPOND_ERROR, errorMessage, errorMessageList, errorMessageMap, nestedResult);
    }

    public static Map<String, Object> returnProblem(String returnType, String errorMessage, List<? extends Object> errorMessageList, Map<String, ? extends Object> errorMessageMap, Map<String, ? extends Object> nestedResult) {
        Map<String, Object> result = FastMap.newInstance();
        result.put(ModelService.RESPONSE_MESSAGE, returnType);
        if (errorMessage != null) {
            result.put(ModelService.ERROR_MESSAGE, errorMessage);
        }

        List<Object> errorList = new LinkedList<Object>();
        if (errorMessageList != null) {
            errorList.addAll(errorMessageList);
        }

        Map<String, Object> errorMap = FastMap.newInstance();
        if (errorMessageMap != null) {
            errorMap.putAll(errorMessageMap);
        }

        if (nestedResult != null) {
            if (nestedResult.get(ModelService.ERROR_MESSAGE) != null) {
                errorList.add(nestedResult.get(ModelService.ERROR_MESSAGE));
            }
        }

        if (errorList.size() > 0) {
            result.put(ModelService.ERROR_MESSAGE_LIST, errorList);
        }
        if (errorMap.size() > 0) {
            result.put(ModelService.ERROR_MESSAGE_MAP, errorMap);
        }
        return result;
    }

    /** A small routine used all over to improve code efficiency, make a result map with the message and the success response code */
    public static Map<String, Object> returnSuccess(String successMessage) {
        return returnMessage(ModelService.RESPOND_SUCCESS, successMessage);
    }

    /** A small routine used all over to improve code efficiency, make a result map with the message and the success response code */
    public static Map<String, Object> returnSuccess() {
        return returnMessage(ModelService.RESPOND_SUCCESS, null);
    }

    /** A small routine to make a result map with the message and the response code
     * NOTE: This brings out some bad points to our message convention: we should be using a single message or message list
     *  and what type of message that is should be determined by the RESPONSE_MESSAGE (and there's another annoyance, it should be RESPONSE_CODE)
     */
    public static Map<String, Object> returnMessage(String code, String message) {
        Map<String, Object> result = FastMap.newInstance();
        if (code != null) result.put(ModelService.RESPONSE_MESSAGE, code);
        if (message != null) result.put(ModelService.SUCCESS_MESSAGE, message);
        return result;
    }

    /** A small routine used all over to improve code efficiency, get the partyId and does a security check
     *<b>security check</b>: userLogin partyId must equal partyId, or must have [secEntity][secOperation] permission
     */
    public static String getErrorMessage(Map<String, ? extends Object> result) {
        StringBuilder errorMessage = new StringBuilder();

        if (result.get(ModelService.ERROR_MESSAGE) != null) errorMessage.append((String) result.get(ModelService.ERROR_MESSAGE));

        if (result.get(ModelService.ERROR_MESSAGE_LIST) != null) {
            List<? extends Object> errors = UtilGenerics.checkList(result.get(ModelService.ERROR_MESSAGE_LIST));
            for (Object message: errors) {
                // NOTE: this MUST use toString and not cast to String because it may be a MessageString object
                String curMessage = message.toString();
                if (errorMessage.length() > 0) {
                    errorMessage.append(", ");
                }
                errorMessage.append(curMessage);
            }
        }

        return errorMessage.toString();
    }
}
